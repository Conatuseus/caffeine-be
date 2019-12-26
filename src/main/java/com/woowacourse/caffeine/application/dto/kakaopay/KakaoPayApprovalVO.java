package com.woowacourse.caffeine.application.dto.kakaopay;

import com.woowacourse.caffeine.application.dto.PaymentSaveRequest;

import java.time.LocalDateTime;

public class KakaoPayApprovalVO {

    private String aid;
    private String tid;
    private String cid;
    private String sid;
    private String partner_order_id;
    private String partner_user_id;
    private String payment_method_type;
    private AmountVO amount;
    private CardVO card_info;
    private String item_name;
    private String item_code;
    private String payload;
    private int quantity;
    private int tax_free_amount;
    private int vat_amount;
    private LocalDateTime created_at, approved_at;

    public KakaoPayApprovalVO() {
    }

    public KakaoPayApprovalVO(final String aid, final String tid, final String cid,
                              final String sid, final String partner_order_id, final String partner_user_id,
                              final String payment_method_type, final AmountVO amount, final CardVO card_info,
                              final String item_name, final String item_code, final String payload,
                              final int quantity, final int tax_free_amount, final int vat_amount,
                              final LocalDateTime created_at, final LocalDateTime approved_at) {
        this.aid = aid;
        this.tid = tid;
        this.cid = cid;
        this.sid = sid;
        this.partner_order_id = partner_order_id;
        this.partner_user_id = partner_user_id;
        this.payment_method_type = payment_method_type;
        this.amount = amount;
        this.card_info = card_info;
        this.item_name = item_name;
        this.item_code = item_code;
        this.payload = payload;
        this.quantity = quantity;
        this.tax_free_amount = tax_free_amount;
        this.vat_amount = vat_amount;
        this.created_at = created_at;
        this.approved_at = approved_at;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(final String aid) {
        this.aid = aid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(final String tid) {
        this.tid = tid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(final String cid) {
        this.cid = cid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(final String sid) {
        this.sid = sid;
    }

    public String getPartner_order_id() {
        return partner_order_id;
    }

    public void setPartner_order_id(final String partner_order_id) {
        this.partner_order_id = partner_order_id;
    }

    public String getPartner_user_id() {
        return partner_user_id;
    }

    public void setPartner_user_id(final String partner_user_id) {
        this.partner_user_id = partner_user_id;
    }

    public String getPayment_method_type() {
        return payment_method_type;
    }

    public void setPayment_method_type(final String payment_method_type) {
        this.payment_method_type = payment_method_type;
    }

    public AmountVO getAmount() {
        return amount;
    }

    public void setAmount(final AmountVO amount) {
        this.amount = amount;
    }

    public CardVO getCard_info() {
        return card_info;
    }

    public void setCard_info(final CardVO card_info) {
        this.card_info = card_info;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(final String item_name) {
        this.item_name = item_name;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(final String item_code) {
        this.item_code = item_code;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(final String payload) {
        this.payload = payload;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public int getTax_free_amount() {
        return tax_free_amount;
    }

    public void setTax_free_amount(final int tax_free_amount) {
        this.tax_free_amount = tax_free_amount;
    }

    public int getVat_amount() {
        return vat_amount;
    }

    public void setVat_amount(final int vat_amount) {
        this.vat_amount = vat_amount;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(final LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getApproved_at() {
        return approved_at;
    }

    public void setApproved_at(final LocalDateTime approved_at) {
        this.approved_at = approved_at;
    }

    public PaymentSaveRequest convertToPaymentSaveRequestDto() {
        return new PaymentSaveRequest(amount.getTotal(), partner_user_id, Long.parseLong(partner_order_id));
    }
}
