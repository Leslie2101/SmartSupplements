import { Card, CardContent } from "@/components/ui/card";

export default function ScanData() {
  return (
    <div className="min-h-screen bg-gradient-to-br from-green-50 via-teal-50 to-emerald-50 p-4">
      <div className="absolute inset-0 overflow-hidden">
        <div className="absolute top-20 left-10 w-32 h-32 bg-green-200/20 rounded-full blur-xl"></div>
        <div className="absolute bottom-20 right-10 w-40 h-40 bg-teal-200/20 rounded-full blur-xl"></div>
      </div>

      <div className="max-w-7xl mx-auto relative z-10">
        <Card className="bg-white/80 backdrop-blur-sm border-white/40 shadow-xl mb-6">
          <CardContent className="pt-6">
            <h1 className="text-3xl font-bold text-gray-800">Empty Page</h1>
            <p className="text-gray-600">This is a blank template you can build on.</p>
          </CardContent>
        </Card>
      </div>
    </div>
  );
}
