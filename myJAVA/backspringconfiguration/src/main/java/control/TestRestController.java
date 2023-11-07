package control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//Controller의 자식 Controller (@ResponseBody 태그 대신)
@RestController
public class TestRestController {
	@GetMapping("/n")
	public void n() {}
	
	@GetMapping("/o")
	public void o() {}
}
