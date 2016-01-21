package arcserver.java.lib.arcserver.rest.test;
import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import arcserver.java.lib.arcserver.rest.Identify;


public class TestIdentify {
	
	@Test
	public void initial() throws ClientProtocolException, IOException{
		Identify id = new Identify();
		String uurl = "http://srvgists011:6080/arcgis/rest/services/Base/Quartieri/MapServer/identify?geometryType=esriGeometryPoint&geometry=720100.2344212551,99105.2328990822&tolerance=1&mapExtent=672483.1900081821,75272.87006183341,732911.4400915466,165702.689912688&imageDisplay=1110,1000,96&returnGeometry=false&f=json";
		
		
		String coordinate = "{x: 720100.2344212551, y: 99105.2328990822}";
		String geometry_params = URLEncoder.encode(coordinate, "UTF-8");
		String url = "http://srvgists011:6080/arcgis/rest/services/Base/Quartieri/MapServer/identify?geometryType=esriGeometryPoint&geometry="+geometry_params+"&tolerance=1&mapExtent=672483.1900081821,75272.87006183341,732911.4400915466,165702.689912688&imageDisplay=1110,1000,96&returnGeometry=false&f=json";
		System.out.println(url);
		
		
		
		
		id.execute(url);
		
	}
	
}
