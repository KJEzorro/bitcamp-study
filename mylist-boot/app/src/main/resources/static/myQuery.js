function myQuery(selector, parent) {

  if (typeof(selector) == "string") {
    if (selector.startsWith("<")) {
      // 파라미터 값이 '<'로  시작한다면 태그를 생성한다.
      var e = document.createElement(selector.substring(1, selector.length - 1))
    } else if (parent != null) {
      // 부모 태그가 지정되어 있으면 그 부모 태그 아래에서 조건에 해당하는 태그를 찾는다.
      var e = parent.querySelector(selector)
    } else {
      // 부모 태그가 지정되어 있지 않으면 HTML 문서 전체에서 조건에 해당하는 태그를 찾는다.
      var e = document.querySelector(selector)
    }
  } else if (selector instanceof HTMLElement) {
    var e = selector
  }

  // 태그의 스타일 값 조회 및 설정
  e.css = function(name, value) {
    if (arguments.length == 1) {
      return e.style[name];
    } else if (arguments.length == 2) {
      e.style[name] = value;
      return e
    }
  }

  // 태그 아래에서 다른 태그 찾기
  e.find = function(selector) {
    return myQuery(selector, e)
  }

  // 태그의 콘텐트(innerHTML 값)를 조회하고 꺼내기 =>  <태그명>콘텐트</태그명>
  e.html = function(content) {
    if (arguments.length == 0) {
      return e.innerHTML
    } else if (arguments.length == 1) {
      e.innerHTML = content
      return e
    }
  }

  // 입력상자의 value 프로퍼티 값을 조회하거나 설정하기(getter/setter)
  e.val = function(v) {
    if (arguments.length == 0) {
      return e.value
    } else {
      e.value = v
      return e
    }
  }

  // 태그의 속성 값을 조회하고 설정하기 (getter/setter)
  e.attr = function(name, value) {
    if (arguments.length == 1) {
      return e.getAttribute(name)
    } else if (arguments.length == 2) {
      e.setAttribute(name, value)
      return e
    }
  }

  // 태그의 부모를 찾아 리턴한다.
  e.parent = function() {
    return myQuery(e.parentNode)
  }

  // 현재 태그를 부모 태그에 자식 태그로 만든다.
  e.appendTo = function(parent) {
    parent.appendChild(e)
  }

  // 현재 태그에 클래스를 추가한다.
  e.addClass = function(name) {
    e.classList.add(name)
    return e
  }

  // 현재 태그에서 해당 클래스를 제거한다.
  e.removeClass = function(name) {
    e.classList.remove(name)
    return e
  }

  // keyup 이벤트 리스너 등록한다.
  e.keyup = function(listener) {
    e.addEventListener("keyup", listener)
    return e
  }

  return e
}

var $ = myQuery
