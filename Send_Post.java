package excelCompiler;

import java.util.ArrayList;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;



public class Send_Post {
	//takes in arguments from excelCombiner
		
		public static void post_me(String id, ArrayList<Integer> numberSetOne, ArrayList<Integer> numberSetTwo, ArrayList<String> wordSetOne) throws Exception {
			
			//create JSON and set url
			
			JSONObject json = new JSONObject();
			String url = new String("http://34.239.125.159:5000/challenge");
			
			//set the params with the id and the sets
			
			json.put("id", id);
			json.put("numberSetOne", numberSetOne);
			json.put("numberSetTwo", numberSetTwo);
			json.put("wordSetOne", wordSetOne);
			
			System.out.println(json);
		    
			//handles connection and post
		    
			CloseableHttpClient httpClient = HttpClients.createDefault();	    
		    HttpPost post = new HttpPost(url);
		    StringEntity params = new StringEntity(json.toString());
		    post.setHeader("Accept","application/json");
		    post.addHeader("content-type", "application/json");
		    post.setEntity(params);
		    CloseableHttpResponse response = httpClient.execute(post);
		    System.out.println(response.getStatusLine().toString());
		    httpClient.close();
		    response.close();
		    }
}


