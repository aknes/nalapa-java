package Nalapa;

/**
 * Created by ananta on 10/1/15.
 */

import org.junit.Before;
import org.junit.Test;
import org.json.*;
import static org.junit.Assert.assertEquals;
import Nalapa.BIOLabel;
import java.util.Iterator;

public class BIOLabelTest {

//    private BIOLabel bio;

    @Before
    public void setUp() {
    }

    @Test
    public void label_shouldReturnBIOLabelFromSingleTag () throws JSONException {
        JSONObject data = new JSONObject("{\"text\" : \"i eat nasi goreng for breakfast, lunch, and dinner\",\"labels\" : [{ \"label\" : \"food\", \"words\" : [\"nasi goreng\"] }]}");
        JSONObject ans = new JSONObject("{\"tokens\":[\"i\",\"eat\",\"nasi\",\"goreng\",\"for\",\"breakfast\",\",\",\"lunch\",\",\",\"and\",\"dinner\"],\"labels\":[[\"other\"],[\"other\"],[\"b_food\"],[\"i_food\"],[\"other\"],[\"other\"],[\"other\"],[\"other\"],[\"other\"],[\"other\"],[\"other\"]]}");
        JSONObject res = BIOLabel.label(data);
        assertEquals(true, ans.has("tokens"));
        assertEquals(true, res.has("labels"));
        assertEquals(ans.getJSONArray("tokens").length(), res.getJSONArray("tokens").length());
        assertEquals(ans.getJSONArray("labels").length(), res.getJSONArray("labels").length());
        assertEquals(ans.toString(), res.toString());
    }

    @Test
    public void label_shouldReturnBIOLabelFromMultipleTag () throws JSONException {
        JSONObject data = new JSONObject("{\"text\" : \"i eat nasi goreng at midnight too\",\"labels\" : [{ \"label\" : \"who\", \"words\" : [\"i\"] },{ \"label\" : \"what\", \"words\" : [\"i eat nasi goreng\"] }]}");
        JSONObject ans = new JSONObject("{\"tokens\":[\"i\",\"eat\",\"nasi\",\"goreng\",\"at\",\"midnight\",\"too\"],\"labels\":[[\"b_who\",\"b_what\"],[\"i_what\"],[\"i_what\"],[\"i_what\"],[\"other\"],[\"other\"],[\"other\"]]}");
        JSONObject res = BIOLabel.label(data);
        assertEquals(true, ans.has("tokens"));
        assertEquals(true, res.has("labels"));
        assertEquals(ans.getJSONArray("tokens").length(), res.getJSONArray("tokens").length());
        assertEquals(ans.getJSONArray("labels").length(), res.getJSONArray("labels").length());
        assertEquals(ans.toString(), res.toString());
    }

    @Test
    public void label_shouldReturnBIOLabelFromMultipleTag2 () throws JSONException {
        JSONObject data = new JSONObject("{\"text\" : \"if you are reading this, you are reading this\",\"labels\" : [{ \"label\" : \"person\", \"words\" : [\"you\"] },{ \"label\" : \"activity\", \"words\" : [\"you are reading\"] }]}");
        JSONObject ans = new JSONObject("{tokens:[\"if\",\"you\",\"are\",\"reading\",\"this\",\",\",\"you\",\"are\",\"reading\",\"this\"],labels:[[\"other\"],[\"b_person\",\"b_activity\"],[\"i_activity\"],[\"i_activity\"],[\"other\"],[\"other\"],[\"b_person\",\"b_activity\"],[\"i_activity\"],[\"i_activity\"],[\"other\"]]}");
        JSONObject res = BIOLabel.label(data);
        assertEquals(true, ans.has("tokens"));
        assertEquals(true, res.has("labels"));
        assertEquals(ans.getJSONArray("tokens").length(), res.getJSONArray("tokens").length());
        assertEquals(ans.getJSONArray("labels").length(), res.getJSONArray("labels").length());
        assertEquals(ans.toString(), res.toString());
    }

    @Test
    public void label_shouldReturnBIOLabelFromMultipleWordsInOneTag () throws JSONException {
        JSONObject data = new JSONObject("{\"text\" : \"friday, saturday, and sunday morning\",\"labels\" : [{ \"label\" : \"day_name\", \"words\" : [\"friday\", \"saturday\", \"sunday\"] },{ \"label\" : \"time\", \"words\" : [\"sunday morning\"] }]}");
        JSONObject ans = new JSONObject("{\"tokens\":[\"friday\",\",\",\"saturday\",\",\",\"and\",\"sunday\",\"morning\"],\"labels\":[[\"b_day_name\"],[\"other\"],[\"b_day_name\"],[\"other\"],[\"other\"],[\"b_day_name\",\"b_time\"],[\"i_time\"]]}");
        JSONObject res = BIOLabel.label(data);
        assertEquals(true, ans.has("tokens"));
        assertEquals(true, res.has("labels"));
        assertEquals(ans.getJSONArray("tokens").length(), res.getJSONArray("tokens").length());
        assertEquals(ans.getJSONArray("labels").length(), res.getJSONArray("labels").length());
        assertEquals(ans.toString(), res.toString());
    }

    @Test
    public void label_shouldNotReturnOtherBIOLabelIfNoLabelsFieldFound () throws JSONException {
        JSONObject data = new JSONObject("{}");
        JSONObject ans = new JSONObject("{\"tokens\":[],\"labels\":[]}");
        JSONObject res = BIOLabel.label(data);
        assertEquals(true, ans.has("tokens"));
        assertEquals(true, res.has("labels"));
        assertEquals(ans.getJSONArray("tokens").length(), res.getJSONArray("tokens").length());
        assertEquals(ans.getJSONArray("labels").length(), res.getJSONArray("labels").length());
        assertEquals(ans.toString(), res.toString());
    }

}
