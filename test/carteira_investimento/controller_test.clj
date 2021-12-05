(ns carteira-investimento.controller-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [carteira-investimento.mocks.stocks :as mock.stocks]
            [carteira-investimento.controller.stocks :as controller.stocks]
            [carteira-investimento.db.stocks :as db.stocks]))

(deftest should-get-stocks
  (testing "should get all stocks"
    (with-redefs [db.stocks/get (fn [clauses] (mock.stocks/mock-get clauses))]
      (let [result (controller.stocks/get-all)]
        (is (= (count result) 1)))))
  
  (testing "should get a stock"
    (with-redefs [db.stocks/get (fn [clauses] (mock.stocks/mock-get clauses))]
      (let [result (controller.stocks/get-by-stock "JHSF" "3")]
        (is (= (count result) 1))
        (is (= (:ticker (-> result (first))) "JHSF"))
        (is (= (:type (-> result (first))) "3"))
        (is (= (:company-name (-> result (first))) "JHSF PARTICIPACOES S.A."))
        (is (= (:business-sector (-> result (first))) "Consumo Cíclico"))
        (is (= (:business-subsector (-> result (first))) "Construção Civil"))
        (is (= (:business-segment (-> result (first))) "Incorporações"))
        (is (= (:qtde-stoks (-> result (first)))) 686224353))))
        
  )