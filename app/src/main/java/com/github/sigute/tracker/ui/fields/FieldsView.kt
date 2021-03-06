package com.github.sigute.tracker.ui.fields

import com.github.sigute.tracker.api.model.Field
import com.github.sigute.tracker.api.model.Member

interface FieldsView {
    fun startLoading()
    fun stopLoading()
    fun showFields(fields: List<Field>)
    fun showMembers(members: List<Member>)
    fun showError(error: String)
}