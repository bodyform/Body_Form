package br.com.fourbbit.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysql.cj.xdevapi.JsonArray;

import br.com.fourbbit.backend.service.StateServiceImpl;
import net.minidev.json.parser.ParseException;

@SpringBootTest
class BackEndApplicationTests {

	@Autowired
	private StateServiceImpl stateServiceImpl;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void  insertStates() throws ParseException, IOException, JSONException {
	
		InputStream inputStream = null;
		JSONObject json = null;
		JSONArray jsonArray = null;
		
		
		inputStream = getClass().getClassLoader()
				.getResourceAsStream("state.json");
		
		
		
		if (inputStream != null) {
            BufferedReader streamReader = new BufferedReader(
				new InputStreamReader(inputStream, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            jsonArray = new JSONArray(inputStream);	
            
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            json = new JSONObject(responseStrBuilder.toString());
            
            
            json = jsonArray.getJSONObject(0);
           
            
            
        }
		 System.out.println(json);
		
	}
}