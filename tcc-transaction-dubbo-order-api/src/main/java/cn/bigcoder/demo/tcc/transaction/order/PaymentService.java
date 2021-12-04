package cn.bigcoder.demo.tcc.transaction.order;

/**
 * @author: Jindong.Tian
 * @date: 2021-12-04
 * @description:
 **/
public interface PaymentService {
    void makePayment(String orderNo);
}
