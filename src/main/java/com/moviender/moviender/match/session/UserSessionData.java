package com.moviender.moviender.match.session;


import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Data
@Component
@SessionScope // her kullanıcı için ayrı ayrı bellek/session
              // her kullanıcı kendine ait id'leri tutar.
public class UserSessionData {
    private List<Integer> selectedGenreIds;
}
