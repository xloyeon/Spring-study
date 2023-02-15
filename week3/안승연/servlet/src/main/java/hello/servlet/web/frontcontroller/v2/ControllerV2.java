package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

    //controllerV1은 void였다면 v2는 MyView 객체를 반환
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}