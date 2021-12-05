(ns carteira-investimento.logic.stocks)

(defn build-stock-clause
  [ticker type]
  (-> {}
      (assoc :ticker ticker)
      (assoc :type type)))