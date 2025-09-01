import { Card, CardContent } from "@/components/ui/card";
import React, { useRef, useState } from "react";


function PhotoUpload() {
  const [preview, setPreview] = useState<string | null>(null);
  const [selectedFile, setSelectedFile] = useState<File | null>(null);
  const fileInputRef = useRef<HTMLInputElement | null>(null);

  const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const file = event.target.files?.[0];
    if (file) {
      setSelectedFile(file);
      setPreview(URL.createObjectURL(file));
    }
  };

  const handleButtonClick = () => {
    fileInputRef.current?.click(); // trigger hidden input
  };

  const handleSubmit = () => {
    if (!selectedFile) {
      alert("Please select a file first.");
      return;
    }

    // Placeholder: handle OCR processing here
    console.log("Submitting file for OCR:", selectedFile);
    alert("File submitted! OCR processing will be implemented later.");
  };

  return (
    <div className="p-4 space-y-4">
      <h1 className="text-xl font-bold">Upload or Take a Photo</h1>

      {/* Hidden file input */}
      <input
        type="file"
        accept="image/*"
        capture="environment"
        onChange={handleFileChange}
        ref={fileInputRef}
        className="hidden"
      />

      {/* Choose / Take Photo Button */}
      <button
        onClick={handleButtonClick}
        className="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600"
      >
        Choose File / Take Photo
      </button>

      {/* Preview */}
      {preview && (
        <div className="mt-2">
          <p className="mb-2 font-semibold">Preview:</p>
          <img src={preview} alt="Preview" className="rounded-lg shadow-md max-w-full max-h-[500px] object-contain" />
        </div>
      )}

      {/* Conditionally render Submit Button */}
      {selectedFile && (
        <button
          onClick={handleSubmit}
          className="px-4 py-2 bg-green-500 text-white rounded-lg hover:bg-green-600"
        >
          Submit for OCR
        </button>
      )}
    </div>
  );
}


// Main ScanData page
export default function ScanData() {
  return (
    <div className="min-h-screen bg-gradient-to-br from-green-50 via-teal-50 to-emerald-50 p-4">
      <div className="absolute inset-0 overflow-hidden">
        <div className="absolute top-20 left-10 w-32 h-32 bg-green-200/20 rounded-full blur-xl"></div>
        <div className="absolute bottom-20 right-10 w-40 h-40 bg-teal-200/20 rounded-full blur-xl"></div>
      </div>

      <div className="max-w-7xl mx-auto relative z-10 space-y-6">
        <Card className="bg-white/80 backdrop-blur-sm border-white/40 shadow-xl mb-6">
          <CardContent className="pt-6">
            <h1 className="text-3xl font-bold text-gray-800">Scan Data</h1>
            <p className="text-gray-600">Upload or take a picture below.</p>
          </CardContent>
        </Card>

        {/* Render PhotoUpload inside the page */}
        <PhotoUpload />
      </div>
    </div>
  );
}
