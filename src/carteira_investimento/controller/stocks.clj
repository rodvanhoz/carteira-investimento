(ns carteira-investimento.controller.stocks
  (:require [carteira-investimento.db.stocks :as db.stocks]
            [carteira-investimento.logic.stocks :as logic.stocks]))

(defn get-all
  []
  (db.stocks/get-all))

(defn get-by-stock
  [ticker type]
  (db.stocks/get (logic.stocks/build-stock-clause ticker type)))