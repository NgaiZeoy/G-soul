package cn.com.gamersoul.controller;

import cn.com.gamersoul.entity.NewUser;
import cn.com.gamersoul.entity.User;
import cn.com.gamersoul.mapper.UserMapper;
import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/verify")
public class VerifyController {
    @Autowired(required = false)
    UserMapper mapper;

    //臻子云短信平台相关参数
    //这个不用改
    private String apiUrl = "https://sms_developer.zhenzikj.com";
    //臻子云系统上获取
    private String appId = "111495";
    private String appSecret = "584a1207-c5dc-4b39-abae-471125c3464c";
    @RequestMapping("/getVerifyCode")
    public String getCode(@RequestBody NewUser newUser, HttpSession httpSession) {
        try {
            User u1 = mapper.selectByUsername(newUser.getUsername());
            User u2 = mapper.selectByMemPhone(newUser.getMem_phone());
            if (u1!=null){
                return "1";//说明用户已存在
            }else if (u2!=null){
                return "2";//说明该号码已被注册
            }
            //获取输入的电话号码
            String memPhone = newUser.getMem_phone();
            JSONObject json = null;
            //随机生成验证码
            String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
            //将验证码通过榛子云接口发送至手机
            ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
            Map<String, Object> params = new HashMap<String, Object>();
            //前台输入的手机号
            params.put("number", memPhone);
            //这个模板id对应的是榛子云个人中心的模板id
            params.put("templateId", 9166);
            String[] templateParams = new String[2];
            templateParams[0] = code;
            templateParams[1] = "1分钟";
            params.put("templateParams", templateParams);
            //发送短信
            String result = client.send(params);
            //System.out.println(result);
            json = JSONObject.parseObject(result);
            if (json.getIntValue("code") != 0) {
                if (json.getString("data").equals("手机号码格式错误")){
                    return "4";//手机号码格式错误
                }
                return "3";//发送短信失败
            }

            //将验证码存到session中,同时存入创建时间
            //以json存放，这里使用的是阿里的fastjson
            json = new JSONObject();
            json.put("memPhone", memPhone);
            json.put("code", code);
            json.put("createTime", System.currentTimeMillis());
            // 将认证码存入session
            httpSession.setAttribute("code", json);
            return code;
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

}
