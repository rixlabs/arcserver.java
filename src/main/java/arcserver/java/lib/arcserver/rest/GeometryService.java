package arcserver.java.lib.arcserver.rest;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GeometryService {
	
	private HashMap<String, String> params;
	
	/*
	public Identify(HashMap<String, String> attrs){
		params = new HashMap<String, String>();
		
		params.put("f", "json");
		params.put("geometry", "");
		params.put("geometryType", "esriGeometryEnvelope");
		params.put("sr:", "");
		params.put("layerDefs", "");
		params.put("time", "");
		params.put("layerTimeOptions", "");
		params.put("layers", "all");
		params.put("tolerance", "2");
		params.put("mapExtent", "");
		params.put("imageDisplay", "");
		params.put("returnGeometry", "true");
		params.put("maxAllowableOffset","");
		
		attrs.putAll(attrs);
	}
	
	*/
	/*
	private URI buildURI(){
		URI = uri = new URIBuilder()
		.setScheme("http")
		.setHost(url)
		.
	}
	*/
	
	public void execute(String URL) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(URL);
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
		    HttpEntity entity = response.getEntity();
		    if (entity != null) {
		        long len = entity.getContentLength();
		        if (len != -1 && len < 2048) {
		            System.out.println(EntityUtils.toString(entity));
		        } else {
		            System.out.println("Way too long");
		            System.out.println(EntityUtils.toString(entity));
		        }
		    }
		} finally {
		    response.close();
		}
	}
	

}
