package arcserver.java.lib.arcserver.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import arcserver.java.lib.arcserver.geometry.Envelope;
import arcserver.java.lib.arcserver.geometry.Geometry;
import arcserver.java.lib.arcserver.geometry.Multipoint;
import arcserver.java.lib.arcserver.geometry.Point;
import arcserver.java.lib.arcserver.geometry.Polygon;
import arcserver.java.lib.arcserver.geometry.Polyline;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GeometryService {
	
	private String URL;
	
	public GeometryService(String URL){
		this.URL = URL;
	}
	

	
	public List<? extends Geometry> project(String inSR,String outSR,Geometry[] geometries) throws ClientProtocolException, IOException, URISyntaxException{
		//public List<? extends Geometry> project(String inSR,String outSR,String geometries) throws ClientProtocolException, IOException, URISyntaxException{
		//String serialized_gemotries = "";
		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		URI uri = new URIBuilder()
        .setScheme("http")
        .setHost(URL)
        .setPath("/project")
        .setParameter("inSR", inSR)
        .setParameter("outSR", outSR)
        .setParameter("geometries", params(geometries))
        .setParameter("f", "json")
        .build();
		
		System.out.println("--------------------URI------------------------------");
		System.out.println(uri.toString());
		
		HttpGet httpget = new HttpGet(uri);
		
		
		
		Gson gson = new Gson();
		
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
		    HttpEntity entity = response.getEntity();
		    if (entity != null) {
		    	//List<Consigliere> consiglieri = new ArrayList<Consigliere>(Arrays.asList(gson.fromJson(strjsong,Consigliere[].class)));
		    	System.out.println("-------------RAW OUTPUT--------------------------");
		    	String json = EntityUtils.toString(entity);
		    	System.out.println(json);
		    	
		    	JsonParser parser = new JsonParser();
		    	JsonObject jObj = parser.parse(json).getAsJsonObject();
		    	
		    	List<Point> resultList = Arrays.asList(gson.fromJson(jObj.get("geometries"), Point[].class));
		    
		        return resultList;
		    }
		} finally {
		    response.close();
		}
		ArrayList<? extends Geometry> aa = new ArrayList<Geometry>();
		return aa;
	}
	
	public String params(Geometry[] geometries){
		//public void params(Geometry[] geometries,List<? extends Geometry> gg){
		
		
		Map<String, Geometry[]> geoStructure = new HashMap<String, Geometry[]>();
		//geoStructure.put("geometries", geometries);
		/*
		Geometry reference = gg.get(0);
		
		if(reference.getClass().equals(Polygon.class)){
			System.out.println("Polygon");
		}
		
		
		
		if(geometries.getClass().equals(Point[].class)){
			System.out.println("Point");
			geoStructure.put("geometries", geometries);
			
			//List<Point> points = new ArrayList<Point>(geometries);
			//geoStructure.put("geometries", geometries);
		}
		else if(geometries.getClass().equals(Polygon.class)){
			System.out.println("Polygon");
			geoStructure = new HashMap<String, List<Polygon>>();
		}
		else if(geometries.getClass().equals(Multipoint.class)){
			System.out.println("Multipoint");
			geoStructure = new HashMap<String, List<Multipoint>>();
		}
		else if(geometries.getClass().equals(Polyline.class)){
			System.out.println("Polyline");
			geoStructure = new HashMap<String, List<Polyline>>();
		}
		else if(geometries.getClass().equals(Envelope.class)){
			System.out.println("Envelope");
			geoStructure = new HashMap<String, List<Envelope>>();
		}
		
		*/
		Gson gson = new Gson();
		System.out.println("test poly");
		HashMap<String, String> finalHash = new HashMap<String, String>();
		finalHash.put("geometryType", geometries[0].getGeometryType());
		finalHash.put("geometries", gson.toJson(geometries));
		System.out.println(finalHash);
		System.out.println(gson.toJson(finalHash));
		String geometry_params = "{geometryType:"+geometries[0].getGeometryType()+",geometries:"+gson.toJson(geometries)+"}";
		//return gson.toJson(finalHash);
		return geometry_params;
		
	}
	/*
	public List<? extends Geometry> genericProjection(String inSR,String outSR,List<? extends Geometry> geometries){
		List<Point> projected = new ArrayList<Point>();
		HashMap<String, ? extends Geometry> geometryStructure = new HashMap<String, ? extends Geometry>();
		geometryStructure.put("geometries", geometries);
		
		Gson gson = new Gson();
		
		return projected;
		
	}
	*/
	public void aaa(List<Geometry> g){
		
		
	}

}
