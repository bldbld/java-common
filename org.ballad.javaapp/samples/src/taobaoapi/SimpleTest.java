package taobaoapi;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TraderatesGetRequest;
import com.taobao.api.response.TraderatesGetResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			TaobaoClient client = new DefaultTaobaoClient("http://gw.api.tbsandbox.com/router/rest", "21736495", "fb98c651775431d2a2fb7f0dd1724854");
			TraderatesGetRequest req = new TraderatesGetRequest();
			req.setFields("tid,oid,role,nick,result,created,rated_nick,item_title,item_price,content,reply,num_iid");
			req.setRateType("get");
			req.setRole("seller");
			req.setResult("good");
			req.setPageNo(1L);
			req.setPageSize(100L);
			Date dateTime = SimpleDateFormat.getDateTimeInstance().parse("2011-01-01 00:00:00");
			req.setStartDate(dateTime);
			dateTime = SimpleDateFormat.getDateTimeInstance().parse("2011-01-02 00:00:00");
			req.setEndDate(dateTime);
			req.setTid(123456L);
			req.setUseHasNext(true);
			req.setNumIid(1234L);
			TraderatesGetResponse response;
			System.out.println (req.getApiMethodName());
			response = client.execute(req, "123");
			System.out.println(response.toString());
		} catch (ApiException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
