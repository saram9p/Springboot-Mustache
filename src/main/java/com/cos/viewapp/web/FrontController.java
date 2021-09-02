package com.cos.viewapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// RestController (데이터를 리턴한다)
// Controller (파일을 리턴한다)

@Controller
public class FrontController {

//	public FrontController(HttpServletRequest request) {
//		// request는 톰캣이 만들어줌, 클라이언트가 요청시에 생성 그래서 에러가 뜸
//	}
	
	//서버실행시 열림
	// http://localhost:8080/home
	// 디스패쳐 서블릿 / home 파싱
	// IoC 컨테이너에 @RestController, @Controller 로 생성된 객체만 찾는다.
	// 메서드를 호출한다.
	// 파싱이 문장을 분석한다는 뜻
	// 컨트롤러에는 전역변수를 사용하지 않는다 (충돌이 발생할 수 있어서)
	
	@GetMapping("/home")
	public String home(Model model) {  // request == model
		// 의존성 주입 : 메서드의 매개변수 주입, 생성자 주입
		// 요청할때마다 열림
		// ViewResolver 클래스
		// src/main/resources/templates (prefix)
		// .mustache (suffix)
		
		String name = "홍길동";
		model.addAttribute("name", name);
		
		List<Board> boards = new ArrayList<>();
		boards.add(new Board(1, "제목1"));
		boards.add(new Board(2, "제목3"));
		
		model.addAttribute("boards", boards);
		
		return "home"	; // RequestDispatcher가 자동 작동
	}
}
