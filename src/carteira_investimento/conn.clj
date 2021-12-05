(ns carteira-investimento.conn
  (:require [korma.db :as korma :refer [defdb]]))
  
(defn- db-conn []
  (korma/postgres
      {:db "carteira_investimento" 
       :user "postgres"
       :password "Geforce560ti"
       :host "192.168.0.11" 
       :port "5432"
       :ssl true
       :sslfactory "org.postgresql.ssl.NonValidatingFactory"}))

(defdb db (db-conn))
