package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/")
	String main() {
		return "index"; 
	}
	
	@RequestMapping("t1")
	String testLink() {
		return "linkView"; 
	}
	
	@RequestMapping("t2")
	String testLink2(@RequestParam(value="name") String name) {
		System.out.println(name);
		return "linkView"; 
	}
	
	@RequestMapping("t3/{num}")
	String testLink3(@PathVariable String num) {
		System.out.println(num);
		return "linkView"; 
	}
	
	
	
}

@Controller
@ResponseBody
@RequestMapping("t4")
class SubController{
	@RequestMapping("")
	String testlink4() {
		System.out.println("@Con + @Resp");
		return "응답 될 데이터입니다."; // 문자열 아니면 객체가 반환타입
	}
	
	@RequestMapping("/{num}")
	String testlink5(@PathVariable String num) {
		System.out.println("@Con + @Resp" + num);
		return "응답 될 데이터입니다."; // 문자열 아니면 객체가 반환타입
	}
	@RequestMapping("t5/{num}")
	String testlink6(@PathVariable String num) {
		System.out.println("@Con + @Resp" + num);
		return "응답 될 데이터입니다."; // 문자열 아니면 객체가 반환타입
	}
}

interface Apple{
	void abf1();
}

@Service // 다른 클래스에서 자동 주입되굉ㅆ다는것을 암시
class AppleImpl implements Apple{
	@Override
	public void abf1() {
		// TODO Auto-generated method stub
		System.out.println("call");
	}
}

@Controller
class Frute{
	@Autowired
	Apple apple;
	
	@RequestMapping("t6")
	String testlink7() {
		apple.abf1();
		return "linkView";
	}
}