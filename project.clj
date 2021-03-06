;; Licensed to the Apache Software Foundation (ASF) under one
;; or more contributor license agreements.  See the NOTICE file
;; distributed with this work for additional information
;; regarding copyright ownership.  The ASF licenses this file
;; to you under the Apache License, Version 2.0 (the
;; "License"); you may not use this file except in compliance
;; with the License.  You may obtain a copy of the License at
;;
;; http:;; www.apache.org/licenses/LICENSE-2.0
;;
;; Unless required by applicable law or agreed to in writing, software
;; distributed under the License is distributed on an "AS IS" BASIS,
;; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
;; See the License for the specific language governing permissions and
;; limitations under the License.
(def VERSION (.trim (slurp "VERSION")))
(def MODULES (-> "MODULES" slurp (.split "\n")))
(def DEPENDENCIES (for [m MODULES] [(symbol (str "storm/" m)) VERSION]))

(eval `(defproject storm/storm ~VERSION
  :url "http://storm-project.net"
  :description "Distributed and fault-tolerant realtime computation"
  :license {:name "Eclipse Public License - Version 1.0" :url "https://github.com/nathanmarz/storm/blob/master/LICENSE.html"}
  :mailing-list {:name "Storm user mailing list"
                 :archive "https://groups.google.com/group/storm-user"
                 :post "storm-user@googlegroups.com"}
  :dependencies [~@DEPENDENCIES]
  :plugins [[~'lein-sub "0.2.1"]]  
  :min-lein-version "2.0.0"
  :sub [~@MODULES]
  ))
