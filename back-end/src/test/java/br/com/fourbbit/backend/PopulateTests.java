package br.com.fourbbit.backend;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import br.com.fourbbit.backend.entity.State;
import br.com.fourbbit.backend.service.StateServiceImpl;
import net.minidev.json.parser.ParseException;

@SpringBootTest
class PopulateTests {

    @Autowired
    private ApplicationContext applicationContext;
    
	@Autowired
	private StateServiceImpl stateServiceImpl;

    @Test
	public void  populateStates() throws ParseException, IOException, JSONException {
	
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<State>> typeReference = new TypeReference<List<State>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/state.json");
		try {
            System.out.println("============================================================");
            System.out.println("== Populating States - Start");
            System.out.println("============================================================");
			List<State> states = mapper.readValue(inputStream,typeReference);
			for(State state : states){
				stateServiceImpl.save(state);
				System.out.println("== State " + state.getName() + " Saved!");
			}
            System.out.println("============================================================");
            System.out.println("== Populating States - Finish");
            System.out.println("============================================================");
		} catch (IOException e){
			System.out.println("Unable to save state: " + e.getMessage());
		}
		
		
	}
}