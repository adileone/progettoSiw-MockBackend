package it.uniroma3.siw.mockBackend;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Class representing RESTful APIs for the primitives.
 * @author Alessandro Di Leone
 *
 */

@RestController
@RequestMapping("/rest")
public class ApiRestController {

	/* Rest LIST*/
	@RequestMapping (value="/list",method = RequestMethod.GET)
	public String list() throws Exception {

		return "Con il backend reale qui ritorna la lista dei dataset inseriti in Kayak";
	}

	/* Rest REFRESH*/
	@RequestMapping (value="/refresh",method = RequestMethod.GET)
	public String refresh() throws Exception {

		return "Con il backend reale qui ritorna la lista aggiornata dei dataset inseriti in Kayak e la lista delle operazioni completed e pending";
	}


	/* Rest RESET*/
	@RequestMapping (value="/reset",method = RequestMethod.GET)
	public String reset() throws Exception {

		return "Con il backend reale vengono resettati i database MongoDB e Neo4j";
	}


	/* Rest INSERT*/
	@RequestMapping (value="/insert",method = RequestMethod.POST)
	private String insert(@RequestParam String filePath,@RequestParam Boolean hasHeader,
			@RequestParam Character charSeparator,@RequestParam String categoryLabel,
			@RequestParam String description) throws Exception {

		return "Con il backend reale viene inserito il dataset selezionato in Kayak";
	}

	/* Rest SET*/
	@RequestMapping (value="/set",method = RequestMethod.POST)
	private String set(@RequestParam String prop, @RequestParam String value) throws Exception {

		return "Con il backend reale questo comando viene utilizzato per settare proprietà in kayak tramite due stringhe proprietà-valore";

	}
	
	//ritorna la lista delle primitive disponibili
	@RequestMapping (value="/primitiveList",method = RequestMethod.GET)
	@ResponseBody
	private List<String> primitiveList() throws Exception {
		List<String> primitiveNames = new ArrayList<>();
		primitiveNames.add("Profile Mandatory");
		primitiveNames.add("Profile Intra");
		primitiveNames.add("Profile Inter");
		primitiveNames.add("Profile Complete");
		return primitiveNames;
	}
	
	@RequestMapping(value="/getPipeline", method = RequestMethod.POST)
	@ResponseBody
	private Document createPipeline(@RequestParam String doc) {
		
		
		System.out.println(doc);	
	
		Document res = new Document().append("message", "pipeline submitted");
	
		return res;
		
	}

}
