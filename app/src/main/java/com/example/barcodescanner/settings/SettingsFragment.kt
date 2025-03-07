                // ... önceki kodlar ...
                R.id.formatJsonDetailed -> SendFormat.JSON_DETAILED
                R.id.formatJsonWithDevice -> SendFormat.JSON_WITH_DEVICE
                R.id.formatXml -> SendFormat.XML
                R.id.formatCsv -> SendFormat.CSV
                else -> SendFormat.PLAIN_TEXT
            }
        }

        Snackbar.make(binding.root, "Settings saved", Snackbar.LENGTH_SHORT).show()
    }

    private fun testConnection() {
        lifecycleScope.launch {
            try {
                val result = NetworkService().sendScanResult("TEST_CONNECTION")
                if (result.isSuccess) {
                    showTestResult(true, "Connection successful!")
                } else {
                    showTestResult(false, "Connection failed: ${result.exceptionOrNull()?.message}")
                }
            } catch (e: Exception) {
                showTestResult(false, "Connection error: ${e.message}")
            }
        }
    }

    private fun showTestResult(success: Boolean, message: String) {
        val icon = if (success) R.drawable.ic_success else R.drawable.ic_error
        val color = if (success) R.color.success_color else R.color.error_color

        com.google.android.material.dialog.MaterialAlertDialogBuilder(requireContext())
            .setIcon(icon)
            .setTitle(if (success) "Success" else "Error")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}