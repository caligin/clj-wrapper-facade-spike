(ns clj-wrapper-facade.core
    (:require [clj-wrapper-facade.a3rdpartylib :as a3p]))

(defn connect
  "our wrapper to connect, only valid opt now is :useTls"
  [host options username password]
  (a3p/connect host {:tlsEnabled (:useTls options) :verifyCert false :some "otheroption"} (a3p/makeCredentials username password)))
