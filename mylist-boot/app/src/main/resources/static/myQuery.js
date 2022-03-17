function myQuery(selector, parent) {
  if (parent != null) {
    // 부모 태그가 지정되어 있으면 그 부모 태그 아래에서 조건에 해당하는 태그를 찾는다.
    var e = parent.querySelector(selector)
  } else {
    // 부모 태그가 지정되어 있지 않으면 HTML 문서 전체에서 조건에 해당하는 태그를 찾는다.
    var e = document.querySelector(selector)
  }

  // 태그에 스타일 설정
  e.css = function(name, value) {
    e.style[name] = value;
  }

  // 태그 아래에서 다른 태그 찾기
  e.find = function(selector) {
    return myQuery(selector, e)
  }

  // 태그의 콘텐트(innerHTML 값)를 꺼내기 =>  <태그명>콘텐트</태그명>
  e.html = function() {
    return e.innerHTML
  }

  // 입력상자의 value 프로퍼티 값을 설정하기
  e.val = function(v) {
    e.value = v
  }

  // 태그의 속성 값을 설정하기
  e.attr = function(name, value) {
    e.setAttribute(name, value)
  }



  return e
}

var $ = myQuery
