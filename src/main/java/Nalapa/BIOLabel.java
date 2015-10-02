package Nalapa;

/**
 * Created by ananta on 10/2/15.
 */

import org.json.*;
import java.util.Iterator;
import org.apache.commons.lang3.ArrayUtils;

public class BIOLabel {

    private static boolean _isAllElementTrue (boolean[] arr) {
        boolean result = true;
        for (boolean el : arr)
            result = result && el;
        return result;
    }

    public static JSONObject label (JSONObject input) throws JSONException {
        String text = (input.has("text") ? input.getString("text") : "");
        String[] tokens = Tokenizer.tokenize(text);

        JSONObject data = new JSONObject();
        data.put("tokens", new JSONArray(tokens));
        String[][] data_labels = new String[tokens.length][];
        for (int i = 0; i < data_labels.length; i++)
            data_labels[i] = new String[]{};

        JSONObject labels = input.getJSONObject("labels");
        Iterator keys = labels.keys();
        while(keys.hasNext()) {
            String key = keys.next() + "";
            JSONArray labelWords = labels.getJSONArray(key);
            for (int i = 0; i < labelWords.length(); i++) {
                String labelWord = labelWords.getString(i);
                String[] labelTokens = Tokenizer.tokenize(labelWord);

                boolean[] matchArray = new boolean[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    boolean[] matchLabelTokens = new boolean[labelTokens.length];
                    for (int k = 0; k < labelTokens.length; k++)
                        matchLabelTokens[k] = (j + k < tokens.length) ? (labelTokens[k].equals(tokens[j + k])) : false;
                    matchArray[j] = BIOLabel._isAllElementTrue(matchLabelTokens);
                }

                int count = 0;
                for (int j = 0; j < matchArray.length; j++) {
                    boolean match = matchArray[j];
                    count = ((match)||(count>0&&count<labelTokens.length)) ? count+1 : 0;
                    if (count == 1)
                        data_labels[j] = ArrayUtils.addAll(data_labels[j], (new String[]{("b_" + key)})) ;
                    else if (count>0 && count<=labelTokens.length)
                        data_labels[j] = ArrayUtils.addAll(data_labels[j], (new String[]{("i_" + key)})) ;
                }
            }
        }
        for (int j = 0; j < data_labels.length; j++)
            if (data_labels[j].length == 0)
                data_labels[j] = new String[]{("other")};

        JSONArray data_labels_json = new JSONArray();
        for (int j = 0; j < data_labels.length; j++)
            data_labels_json.put((new JSONArray(data_labels[j])));
        data.put("labels", data_labels_json);
        return data;
    }
}
