package com.egecius.demo_androidplatform.services

import android.annotation.SuppressLint
import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Handler
import android.widget.Toast

@SuppressLint("NewApi")
class MyJobService : JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        Toast.makeText(this, "onStartJob", Toast.LENGTH_SHORT).show()
        scheduleJobFinished(params)
        return true // needs processing on a separate thread
    }

    private fun scheduleJobFinished(params: JobParameters?) {
        Handler().postDelayed({
            Toast.makeText(this, "jobFinished", Toast.LENGTH_SHORT).show()
            jobFinished(params, false)}, 3000)
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Toast.makeText(this, "onStopJob", Toast.LENGTH_SHORT).show()
        return true // reschedule
    }
}