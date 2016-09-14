package br.com.lvnascimento.videolocadorajsfhib.iu;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Leonardo
 */
public class FiltroTransacao implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession sessaoHTTP = req.getSession(false);
        TransacaoVideolocadora transacaoCorrente = null;
        if(req.getRequestURI().endsWith(".xhtml") && sessaoHTTP != null) {
            transacaoCorrente = (TransacaoVideolocadora) 
                    sessaoHTTP.getAttribute("transacaoCorrente");
            if(transacaoCorrente != null) {
                transacaoCorrente.iniciarRequisicao();
            }
        }
        chain.doFilter(request, response);
        if(req.getRequestURI().endsWith(".xhtml") && sessaoHTTP != null && 
                transacaoCorrente != null) {
            transacaoCorrente.finalizarRequisicao();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    
    @Override
    public void destroy() {
       
    }
    
}
