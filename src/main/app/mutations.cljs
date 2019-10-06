(ns app.mutations
  (:require
   [com.fulcrologic.fulcro.mutations :as m :refer [defmutation]]
   [com.fulcrologic.fulcro.algorithms.merge :as merge]))

(defmutation delete-person
  "Mutation: Delete some shit"
  [{list-id :list/id
    person-id :person/id}]
  (action [{:keys [state]}]
          (js/console.log list-id person-id)
          (swap! state merge/remove-ident* [:person/id person-id] [:list/id list-id :list/people]))
  (remote [env] true))
