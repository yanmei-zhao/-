//		function showTime(){
//	    // 1.获取时间对象
//		var date = new Date();
//		// 2.获取年月日、时分秒
//		var year = date.getFullYear();
//		var month = date.getMonth() + 1;
//		var day = date.getDate();
//		var hour = date.getHours();
//		var minute = date.getMinutes();
//		var second = date.getSeconds();
//		// 3.给小于10的数字前补0
///*		if(hour<10){
//			hour = '0' + hour;
//		}
//		if(minute<10){
//			minute = '0' + minute;
//		}
//		if(second<10){
//			second = '0' + second;
//		}*/
//		// 封装成函数
//		month=addZero(month);
//		day=addZero(day);
//		hour=addZero(hour);
//		minute=addZero(minute);
//		second=addZero(second);
//		// 4.拼接字符串（此处需注意，必须拼接一个字符串，空串也行，否则将会变成数字相加）
//		var time = year + '年' + month + '月' + day + ' ' + hour + ':' + minute + ':' + second;
//		document.getElementById('box').innerHTML = time;
//	}
//	// 为数字添加0前缀
//			function addZero(num){
//				if(num<10){
//					num='0'+num;
//				}
//				return num;
//			}
//			// 先调用一次
//			showTime();  //目的：衔接，
//			setInterval(showTime,100000);  //每1s执行一次代码(所以开始执行的时候会间隔1s)
//	
//	
//	function getTime(){
//		var date = new Date();
//		var year = date.getFullYear();
//		var month = date.getMonth() + 1;
//		var day = date.getDate();
//		var hour = date.getHours();
//		var minute = date.getMinutes();
//		var second = date.getSeconds();
//
//		// 封装成函数
//		month=addZero(month);
//		day=addZero(day);
//		hour=addZero(hour);
//		minute=addZero(minute);
//		second=addZero(second);
//
//		var time = year + '年' + month + '月' + day + ' 日' + hour + ':' + minute + ':' + second;
//		document.getElementById('box').innerHTML = time;
//		setTimeout(getTime,100000);
//	}
//	// 为数字添加0前缀
//	function addZero(num){
//		if(num<10){
//			num='0'+num;
//		}
//		return num;
//	}
//	getTime();  //函数必须调用，否则不执行！！
//
//	
//	
//	function showTime(){
//		var date = new Date();  //获取当前时间
//		var now = date.getTime();  //获取当前GMT时间 
//		//dateObject.getTime()，dateObject指定的日期和时间距 1970年 1月 1日午夜（GMT 时间）之间的毫秒数。
//		var endDate = new Date("2019-1-9 00:00:00");  //获取结束时间
//		var end = endDate.getTime();  //获取结束GMT时间
//		var diffTime = end - now;  //计算时间差
//		console.log(diffTime);
//		var d,h,m,s,ms;
//		if(diffTime>=0){
//			ms = Math.floor(diffTime % 1000);  
//			console.log(ms);
//			s = Math.floor(diffTime / 1000 % 60);
//			m = Math.floor(diffTime / 1000 / 60 % 60);
//			h = Math.floor(diffTime / 1000 / 60 / 60 % 24);
//			d = Math.floor(diffTime / 1000 / 60 / 60 / 24);
//			
//			// 封装成函数
//			d=addZero(d);
//			h=addZero(h);
//			m=addZero(m);
//			s=addZero(s);
//			if(ms<100){
//				ms = '0' + ms;
//				if(ms<10){
//				ms = '00' + ms;
//				}
//			}
//			
//			var time = d + '天' + h + '时' + m + '分' + s + '秒' + ms + '毫秒';
//			document.getElementById('box').innerHTML = time;
//		}else{
//			alert("倒计时结束！！");
//		}
//	}
//	// 为数字添加0前缀
//	function addZero(num){
//		if(num<10){
//			num='0'+num;
//		}
//		return num;
//	}
//	showTime();
//	setInterval(showTime,100000);

function getTime(){
	var remainTime=document.getElementById("remainTime").getElementsByTagName("span");
	setInterval(function(){
	var timeing=new Date(2020,0,10,17,35,0);
	var minutes=Number(120);
	var end = timeing.setMinutes(timeing.getMinutes()+minutes);
	var now = new Date().getTime();//当前时间
	var num = end-now;//持续时间
	var minute=parseInt(num/(60*1000));
    num=num%(60*1000);
    var seconde=parseInt(num/1000);
	  remainTime[0].innerHTML=minute;
	  remainTime[1].innerHTML=seconde;
	/*var time=new Date(2020,0,10,14,47,0);
	var num=time.getTime()-timeing.getTime();
//    var day=parseInt(num/(24*60*60*1000));			
//    num=num%(24*60*60*1000);
//    var hour=parseInt(num/(60*60*1000));            
//    num=num%(60*60*1000);
    var minute=parseInt(num/(60*1000));
    num=num%(60*1000);
//    var minute=120;
    var seconde=parseInt(num/1000);
//      show[0].innerHTML=day;
//      show[1].innerHTML=hour;
    remainTime[0].innerHTML=minute;
    remainTime[1].innerHTML=seconde;*/
    },100)
}