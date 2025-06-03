from pydantic import BaseModel

class Competition(BaseModel):
    id: str
    name: str
    country: str
    confederation: str
    logo_url: str
    logo_url_dark: str