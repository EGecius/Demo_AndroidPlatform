package com.egecius.demo_androidplatform.services

import android.annotation.SuppressLint
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context

class MyJobSchedulerHelper(private val context: Context) {

    @SuppressLint("NewApi")
    fun scheduleJob() {

        val jobScheduler: JobScheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

        val componentName = ComponentName(context, MyJobService::class.java)

        val jobInfo = JobInfo.Builder(JOB_ID, componentName)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .build()

        jobScheduler.schedule(jobInfo)
    }

    companion object {
        const val JOB_ID = 23823
    }
}
