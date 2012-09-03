package tdrw;

import helper.StringHelper;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class UrlTextBuilder implements TextBuilder {
	private String url;
	
	public UrlTextBuilder(String url){
		this.url = url;
	}
	
	@Override
	public String getText() {
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			
			InputStream is = entity.getContent();
			
			return StringHelper.inputStreemToString(is);
			
		} catch (Exception ex) {
			return null;
		}
	}
}
