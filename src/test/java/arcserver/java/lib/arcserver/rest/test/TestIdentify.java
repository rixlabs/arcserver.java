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
		String coordinates = "{y:40.746154,x:-73.989684}";
		String geometry_params = URLEncoder.encode(coordinates, "UTF-8");
		String url = "http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Specialty/ESRI_StateCityHighway_USA/MapServer/identify?geometryType=esriGeometryPoint&geometry="+geometry_params+"&tolerance=1&mapExtent=672483.1900081821,75272.87006183341,732911.4400915466,165702.689912688&imageDisplay=1110,1000,96&returnGeometry=false&f=json";
		System.out.println(url);
		
		
		
		
		id.execute(url);
		
	}
	
}
