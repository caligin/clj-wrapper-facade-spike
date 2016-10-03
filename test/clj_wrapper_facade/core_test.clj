(ns clj-wrapper-facade.core-test
  (:use midje.sweet)
  (:require [clj-wrapper-facade.core :as wfc]))

(facts "about the a3p connector thing"
    (fact "tls option is translated"
        (:tlsEnabled (wfc/a3p-options-translate {:useTls true})) => true
        (:tlsEnabled (wfc/a3p-options-translate {:useTls false})) => false)
    (fact "verifyCert is defaulted to false"
        (:verifyCert (wfc/a3p-options-translate {})) => false)
    (fact "generic connect forwards args to fn"
        (let [returnerConnectorFn (fn [host options username password] {:host host :options options :username username :password password})]
        (:host (wfc/generic-connect returnerConnectorFn "h" {} "u" "p")) => "h"
        (:options (wfc/generic-connect returnerConnectorFn "h" {} "u" "p")) => {}
        (:username (wfc/generic-connect returnerConnectorFn "h" {} "u" "p")) => "u"
        (:password (wfc/generic-connect returnerConnectorFn "h" {} "u" "p")) => "p")))