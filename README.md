# board2 (rest api)
게시판 사이트 ver2
-------------------------------
<h4>환경</h4>  
<div>java 17 </div> 
<div>spring 3.0.4  </div>
<div>lombok  </div>
<br/>
<br/>
<h4>기능</h4>  
<h5>회원가입  localhost:80/api/v1/user?name=user3&password=1234 (post) </h5> 
<h5>로그인  localhost:80/api/v1/login?name=user2&password=1234  (get) </h5> 
<h5>로그아웃  localhost:80/api/v1/logout(get)  </h5>
<h5>게시글 작성  localhost:80/api/v1/question?title=제목7&content=내용 (post)  </h5>
<h5>게시글 조회  localhost:80/api/v1/question?page=0 (get)  </h5>
<h5>추천  localhost:80/api/v1/question/like/{id} (post)  </h5>

-----------------------------------------------  
# 3-21일지  
1. 인터셉터의 변경이 필요하다.  
      -세션의 정보로 eunm클래스 생성중.  
      -method의 구분이 없어서 문제다.  

2. 인터셉터로 권한이 없는 사용자의 접근을 막는다.  

3. 인터셉터 재구성  
      -세션은 로그인을 할 시 생성된다.  
      -세션의 정보는 아이디와 권한이다.   
      -...정리가 필요하여 멈춤.  


# 3-22일지  
1. 어제 수정한 인터셉터 역시 비효율적이다.  
      -지금은 webmvcconfig에서 경로를 설정해서 받아오고 있지만 mothod의 구분이 되지 않아 문제가 발생한다.  
      
      -경로를 비교하는 class를 생성하자.  
      -(다만 그렇게 된다면 webmvcconfig를 사용하는 이유가 조금 애메해 질 것 같다.)  
      
2. url, method, auth(List) 맴버변수를 가진 클래스를 만들고 bean으로 등록하여 초기 설정값을 줄 수 있게 만들었다.  
      -(지금은 "/api/v1/question/",POST,(user,admin) 제한조건만 생성됨)  
   
      -위 주소로 들어오는 post 요청이면 권한을 확인해서 true,false로 리턴한다. 나머지 요청들은 전부 패스!  
      
      -이제 pathinfo클래스에 조건들을 추가하면 알아서 정리가 된다.  
      (하지만 config 클래스의 필요성이 확연히 줄어들었다. 차이점은 config는 \**같은 범위 설정이 가능하다는 점)  
      
3. 변하는 url에 대해서 문제가 발생한다.(/{id})  
      -replaceAll 정규식을 이용하여 임시방편으로 막았다..(문제가 크다..)  



