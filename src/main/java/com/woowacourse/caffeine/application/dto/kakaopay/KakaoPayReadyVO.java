package com.woowacourse.caffeine.application.dto.kakaopay;

import java.time.LocalDateTime;

public class KakaoPayReadyVO {

    private String tid;
    private String next_redirect_pc_url;
    private LocalDateTime created_at;

    public KakaoPayReadyVO() {
    }

    public KakaoPayReadyVO(final String tid, final String next_redirect_pc_url, final LocalDateTime created_at) {
        this.tid = tid;
        this.next_redirect_pc_url = next_redirect_pc_url;
        this.created_at = created_at;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(final String tid) {
        this.tid = tid;
    }

    public String getNext_redirect_pc_url() {
        return next_redirect_pc_url;
    }

    public void setNext_redirect_pc_url(final String next_redirect_pc_url) {
        this.next_redirect_pc_url = next_redirect_pc_url;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(final LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
