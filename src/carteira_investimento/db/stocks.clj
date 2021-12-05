(ns carteira-investimento.db.stocks
  (:require  [korma.db :refer :all]
             [korma.core :refer :all]
             [clojure.java.jdbc :as sql]
             [clojure.tools.logging :as log]
             [carteira-investimento.conn :as conn]
             [carteira-investimento.db.entities :as e]))

(defn get
  [clauses]
  {})

(defn get-all
  []
  (get true))