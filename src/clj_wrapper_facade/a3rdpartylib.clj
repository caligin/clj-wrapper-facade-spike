(ns clj-wrapper-facade.a3rdpartylib)

(defn connect
  "connects to something"
  [host options credentials]
  (println x "connecting to something"))

(defn makeCredentials
    "makes a credentials object, because yes"
    [username password]
    {:u username :p password})
