package cn.spider.design.behavior.strategy.delegate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<>();

    public void init() throws ServletException {
        try {
            Class<?> memberControllerClass = MemberController.class;
            handlerMapping.add(new Handler().
                    setController(memberControllerClass.newInstance()).
                    setMethod(memberControllerClass.getMethod("getMemberById", new Class[]{String.class})).
                    setUrl("/web/getMemberById.json"));

        } catch (Exception e) {

        }
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }
        Object object = null;
        try {
            assert handler != null;
            object = handler.getMethod().invoke(handler.getController(), request.getPart("id"));

        } catch (Exception ignore) {

        }
        assert object != null;
        response.getWriter().write(object.toString());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception ignore) {
        }
    }

    class Handler {
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }

    class MemberController {

    }

}
