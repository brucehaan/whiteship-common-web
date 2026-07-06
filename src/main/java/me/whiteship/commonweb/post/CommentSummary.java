package me.whiteship.commonweb.post;

import org.springframework.beans.factory.annotation.Value;

public interface CommentSummary {
    String getComment();
    int getUp();
    int getDown();

    default String getVotes() { // 백기선 추천
        return getUp() + " " + getDown();
    }

//    @Value("#{target.up + ' ' + target.down}")
//    String getVotes();
}
