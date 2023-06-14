package com.sutaruhin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBootController {

	//http://localhost:8080/にアクセスすると画面に「Hello SpringBoot!」と表示
	@GetMapping("/")
	public String index() {
		return "Hello SpringBoot!";
	}


	//http://localhost:8080/now/にアクセスすると、サーバの現在時刻を画面に表示
	@GetMapping("now")
	public String dispTime() {
		String now = LocalDateTime.now().format( DateTimeFormatter.ofPattern("HH.mm.ss") );

		return "現在時刻： " + now;
	}

	/*アノテーションを見てみると、 @GetMapping("/plus/{val1}/{val2}") となっています。
	 * この{val1}と{val2}の部分は「パスパラメータ」と呼ばれるURLのパス部分に指定した値を変数として取り出す機能です。
	 * それぞれの変数は@PathVariableというアノテーションで取得できます。
	 */
	@GetMapping("/plus/{val1}/{val2}")
	public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 + val2;
		return "計算結果： " + res;
	}

}
