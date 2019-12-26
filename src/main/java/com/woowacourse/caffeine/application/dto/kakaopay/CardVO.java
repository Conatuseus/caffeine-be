package com.woowacourse.caffeine.application.dto.kakaopay;

public class CardVO {

    private String purchase_corp;
    private String purchase_corp_code;
    private String issuer_corp;
    private String issuer_corp_code;
    private String bin;
    private String card_type;
    private String install_month;
    private String approved_id;
    private String card_mid;
    private String interest_free_install;
    private String card_item_code;

    public CardVO() {
    }

    public CardVO(final String purchase_corp, final String purchase_corp_code, final String issuer_corp,
                  final String issuer_corp_code, final String bin, final String card_type,
                  final String install_month, final String approved_id, final String card_mid,
                  final String interest_free_install, final String card_item_code) {
        this.purchase_corp = purchase_corp;
        this.purchase_corp_code = purchase_corp_code;
        this.issuer_corp = issuer_corp;
        this.issuer_corp_code = issuer_corp_code;
        this.bin = bin;
        this.card_type = card_type;
        this.install_month = install_month;
        this.approved_id = approved_id;
        this.card_mid = card_mid;
        this.interest_free_install = interest_free_install;
        this.card_item_code = card_item_code;
    }

    public String getPurchase_corp() {
        return purchase_corp;
    }

    public void setPurchase_corp(final String purchase_corp) {
        this.purchase_corp = purchase_corp;
    }

    public String getPurchase_corp_code() {
        return purchase_corp_code;
    }

    public void setPurchase_corp_code(final String purchase_corp_code) {
        this.purchase_corp_code = purchase_corp_code;
    }

    public String getIssuer_corp() {
        return issuer_corp;
    }

    public void setIssuer_corp(final String issuer_corp) {
        this.issuer_corp = issuer_corp;
    }

    public String getIssuer_corp_code() {
        return issuer_corp_code;
    }

    public void setIssuer_corp_code(final String issuer_corp_code) {
        this.issuer_corp_code = issuer_corp_code;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(final String bin) {
        this.bin = bin;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(final String card_type) {
        this.card_type = card_type;
    }

    public String getInstall_month() {
        return install_month;
    }

    public void setInstall_month(final String install_month) {
        this.install_month = install_month;
    }

    public String getApproved_id() {
        return approved_id;
    }

    public void setApproved_id(final String approved_id) {
        this.approved_id = approved_id;
    }

    public String getCard_mid() {
        return card_mid;
    }

    public void setCard_mid(final String card_mid) {
        this.card_mid = card_mid;
    }

    public String getInterest_free_install() {
        return interest_free_install;
    }

    public void setInterest_free_install(final String interest_free_install) {
        this.interest_free_install = interest_free_install;
    }

    public String getCard_item_code() {
        return card_item_code;
    }

    public void setCard_item_code(final String card_item_code) {
        this.card_item_code = card_item_code;
    }
}
