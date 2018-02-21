package connexionBDD;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class Environnement extends ActionSupport implements ApplicationAware, SessionAware{

    private Map<String, Object> variablesSession;

    public Map<String, Object> getVariablesSession() {
        return variablesSession;
    }

    @Override
    public void setApplication(Map<String, Object> map) {

    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.variablesSession = map;
    }
}
