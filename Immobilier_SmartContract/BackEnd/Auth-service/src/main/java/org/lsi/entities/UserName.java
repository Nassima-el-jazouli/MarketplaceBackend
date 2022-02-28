//
//package org.lsi.entities;
//
//import org.springframework.data.domain.AuditorAware;
//
//import javax.servlet.http.HttpServletRequest;
//import java.security.Principal;
//import java.util.Optional;
//
//
//public class UserName implements AuditorAware<String> {
//
//    private final HttpServletRequest httpServletRequest;
//
//    public UserName(HttpServletRequest httpServletRequest) {
//        this.httpServletRequest = httpServletRequest;
//    }
//
//    @Override
//    public Optional<String> getCurrentAuditor() {
//        return Optional.ofNullable(httpServletRequest.getUserPrincipal())
//                .map(Principal::getName);
//    }
//}
//
//
