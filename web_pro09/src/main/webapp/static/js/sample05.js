/**
*
 */
 function f1(){
	var id1 = document.getElementById("id1");
	var first_li = id1.firstElementChild;
	var last_li = id1.lastElementChild;
	
	first_li.style.color = "red";
	last_li.style.color = "blue";
}
  

function f2() {
	var id2 = document.getElementById("id2"); //목록3을 기준으로
	var prev_li = id2.previousElementSibling; //전 -1
	var next_li = id2.nextElementSibling; //후 +1
	
	prev_li.style.color = "red";
	next_li.style.color = "blue";
}
//ul.appendChild(li);
//li.appendChild(a); append는 가급적 마지막에 넣어주기
function f3() {
	var id3 = document.getElementById("id3");
	var ul = id3.parentElement;// 부모를 선택해서 만들어줌.
	
	ul.style.backgroundColor = "white";
	
}
 
 function addUrlList() {
	var url= document.getElementById("id_url");
	var name= document.getElementById("id_name");
	var num = document.getElementById("id_num");
    var idx = parseInt(num.value);
 
    if(!url.value) {
	      url.focus();
	      return;
	   }else if(!name.value){
		 name.focus();
		 return;
	   }
    
     var li_tags = document.getElementsByTagName("li");
     console.log(li_tags);
     if(!idx || idx > li_tags.length || idx <= 0) {
	     idx =li_tags.length -1;
     }else{
	      idx = idx-2;
     }
     console.log("1 : "+idx);

     
     var li = document.createElement("li");
     var a = document.createElement("a");
     
     a.setAttribute("href",url.value);
     a.innerText = name.value;
     
 
     li.appendChild(a);
     if(idx <0) {
        li_tags[0].before(li);
     }else{
        li_tags[idx].after(li);
	   
}
 
      url.value="";
      name.value ="";  //초기화하기위해서
      num.value="";
      num.focus();
}