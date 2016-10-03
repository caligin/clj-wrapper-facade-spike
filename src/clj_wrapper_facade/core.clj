(ns clj-wrapper-facade.core
    (:require [clj-wrapper-facade.a3rdpartylib :as a3p]))

; should be private/anonymous/another module
(defn generic-connect
    "the connectorFn expects [host options uname pwd]"
    [connectorFn host options uname pwd]
    (connectorFn host options uname pwd))

; should be private/anonymous/another module
(defn a3p-options-translate
    "translate our options in the implementation options"
    [options]
    {:tlsEnabled (:useTls options) :verifyCert false :some "otheroption"})

; should be private/anonymous/another module
(defn a3p-connector
    "connectorFn implementation for a3p library"
    [host options username password]
    (a3p/connect host (a3p-options-translate options) (a3p/makeCredentials username password)))

(defn connect
  "our wrapper to connect, only valid opt now is :useTls, the reference implementation uses a3p"
  [host options username password]
  (generic-connect a3p-connector host options username password))
