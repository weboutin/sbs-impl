package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.JSONException;
import utils.Utils;

public class Users extends HttpServlet {
    /**
     * POST /v1/users
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String json = IOUtils.toString(request.getInputStream(), "utf8");
            JSONObject input = new JSONObject(json);
            System.out.println(input);
            String account = input.optString("account");
            String password = input.optString("password");
            System.err.println(account);
            System.err.println(password);
            
            JSONObject data = new JSONObject();
            Utils.buildResponse(response, 0, "注册成功", data);
        } catch (JSONException e) {
            JSONObject data = new JSONObject();
            Utils.buildResponse(response, 1, "参数异常", data);
        } catch (Exception e) {
            JSONObject data = new JSONObject();
            Utils.buildResponse(response, -1, "系统异常", data);
        }
    }
}