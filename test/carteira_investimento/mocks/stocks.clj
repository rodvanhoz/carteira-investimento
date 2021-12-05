(ns carteira-investimento.mocks.stocks
  (:require [carteira-investimento.utils.adapters :refer [not-nil?]]))

(def stocks (list {:uuid "50888255-1906-433e-b478-f9c48da8b9b7" :ticker "JHSF" :type "3" :company_name "JHSF PARTICIPACOES S.A." :business_sector "Consumo Cíclico" :business_subsector "Construção Civil" :business_segment "Incorporações" :qtde_stoks 686224353}))

(defn- select-get [data]
  (doall (map (fn [v]
                (-> {}
                    (assoc :uuid (:uuid v))
                    (assoc :ticker (:ticker v))
                    (assoc :type (:type v))
                    (assoc :company-name (:company_name v))
                    (assoc :business-sector (:business_sector v))
                    (assoc :business-subsector (:business_subsector v))
                    (assoc :business-segment (:business_segment v))
                    (assoc :qtde-stoks (:qtde_stoks v))))
            data)))


(defn- mock-get-by-uuid [uuid]
  (select-get (filter #(= (str uuid) (:uuid %)) stocks)))

(defn- mock-get-by-ticker [ticker]
  (select-get (filter #(= ticker (:ticker %)) stocks)))

(defn- mock-get-by-stock [ticker type]
  (let [result (select-get (filter #(= ticker (:ticker %)) stocks))]
    (filter #(= type (:type %)) result)))
  
(defn mock-get [clauses]
  (if (not-nil? (:uuid clauses))
    (mock-get-by-uuid (:uuid clauses))
    (if (and (not-nil? (:ticker clauses)) (not-nil? (:type clauses)))
      (mock-get-by-stock (:ticker clauses) (:type clauses))
      (if (not-nil? (:ticker clauses))
        (mock-get-by-ticker (:ticker clauses))
        (select-get stocks)))))
    
